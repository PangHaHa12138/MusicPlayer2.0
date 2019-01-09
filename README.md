# MusicPlayerdemo
a MusicPlayer for Android
#
仿网易云音乐 可扫描本地音乐播放
#
核心播放页 唱盘的实现
#
1:首先是背景高斯迷糊，先切割图片一部分，然后缩小图片，利用FastBlur高斯模糊 最后加上灰色遮罩
```
 private Drawable getForegroundDrawable(int musicPicRes) {
        /*得到屏幕的宽高比，以便按比例切割图片一部分*/
        final float widthHeightSize = (float) (DisplayUtil.getScreenWidth(MusicPlayActivity.this)
                * 1.0 / DisplayUtil.getScreenHeight(this) * 1.0);

        Bitmap bitmap = getForegroundBitmap(musicPicRes);
        int cropBitmapWidth = (int) (widthHeightSize * bitmap.getHeight());
        int cropBitmapWidthX = (int) ((bitmap.getWidth() - cropBitmapWidth) / 2.0);

        /*切割部分图片*/
        Bitmap cropBitmap = Bitmap.createBitmap(bitmap, cropBitmapWidthX, 0, cropBitmapWidth,
                bitmap.getHeight());
        /*缩小图片*/
        Bitmap scaleBitmap = Bitmap.createScaledBitmap(cropBitmap, bitmap.getWidth() / 50, bitmap
                .getHeight() / 50, false);
        /*模糊化*/
        final Bitmap blurBitmap = FastBlurUtil.doBlur(scaleBitmap, 8, true);

        final Drawable foregroundDrawable = new BitmapDrawable(blurBitmap);
        /*加入灰色遮罩层，避免图片过亮影响其他控件*/
        foregroundDrawable.setColorFilter(Color.GRAY, PorterDuff.Mode.MULTIPLY);
        return foregroundDrawable;
    }

    private Bitmap getForegroundBitmap(int musicPicRes) {
        int screenWidth = DisplayUtil.getScreenWidth(this);
        int screenHeight = DisplayUtil.getScreenHeight(this);

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;

        BitmapFactory.decodeResource(getResources(), musicPicRes, options);
        int imageWidth = options.outWidth;
        int imageHeight = options.outHeight;

        if (imageWidth < screenWidth && imageHeight < screenHeight) {
            return BitmapFactory.decodeResource(getResources(), musicPicRes);
        }

        int sample = 2;
        int sampleX = imageWidth / DisplayUtil.getScreenWidth(this);
        int sampleY = imageHeight / DisplayUtil.getScreenHeight(this);

        if (sampleX > sampleY && sampleY > 1) {
            sample = sampleX;
        } else if (sampleY > sampleX && sampleX > 1) {
            sample = sampleY;
        }

        options.inJustDecodeBounds = false;
        options.inSampleSize = sample;
        options.inPreferredConfig = Bitmap.Config.RGB_565;

        return BitmapFactory.decodeResource(getResources(), musicPicRes, options);
    }
```
2:合成唱盘
 首先设置一个透明的圆背景 RoundedBitmapDrawable 然后拿到封面，生成圆形Drawable,还有黑胶部分，之后利用LayerDrawable(它类似ps的图层，可以将一个数组里的drawable合成一个drawable 索引最大盖在最上面) 把封面和黑胶合成唱片，这里还对图片进行了压缩避免oom
 ```
 /*得到唱盘背后半透明的圆形背景*/
    private Drawable getDiscBlackgroundDrawable() {
        int discSize = (int) (mScreenWidth * DisplayUtil.SCALE_DISC_SIZE);
        Bitmap bitmapDisc = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(),
                R.drawable.ic_disc_blackground), discSize, discSize, false);
        RoundedBitmapDrawable roundDiscDrawable = RoundedBitmapDrawableFactory.create
                (getResources(), bitmapDisc);
        return roundDiscDrawable;
    }

    /**
     * 得到唱盘图片
     * 唱盘图片由空心圆盘及音乐专辑图片“合成”得到
     */
    private Drawable getDiscDrawable(int musicPicRes) {
        int discSize = (int) (mScreenWidth * DisplayUtil.SCALE_DISC_SIZE);
        int musicPicSize = (int) (mScreenWidth * DisplayUtil.SCALE_MUSIC_PIC_SIZE);

        Bitmap bitmapDisc = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(),
                R.drawable.ic_disc), discSize, discSize, false);
        Bitmap bitmapMusicPic = getMusicPicBitmap(musicPicSize, musicPicRes);
        BitmapDrawable discDrawable = new BitmapDrawable(bitmapDisc);
        RoundedBitmapDrawable roundMusicDrawable = RoundedBitmapDrawableFactory.create
                (getResources(), bitmapMusicPic);

        //抗锯齿
        discDrawable.setAntiAlias(true);
        roundMusicDrawable.setAntiAlias(true);

        Drawable[] drawables = new Drawable[2];
        drawables[0] = roundMusicDrawable;
        drawables[1] = discDrawable;

        LayerDrawable layerDrawable = new LayerDrawable(drawables);
        int musicPicMargin = (int) ((DisplayUtil.SCALE_DISC_SIZE - DisplayUtil
                .SCALE_MUSIC_PIC_SIZE) * mScreenWidth / 2);
        //调整专辑图片的四周边距，让其显示在正中
        layerDrawable.setLayerInset(0, musicPicMargin, musicPicMargin, musicPicMargin,
                musicPicMargin);

        return layerDrawable;
    }

    private Bitmap getMusicPicBitmap(int musicPicSize, int musicPicRes) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;

        BitmapFactory.decodeResource(getResources(), musicPicRes, options);
        int imageWidth = options.outWidth;

        int sample = imageWidth / musicPicSize;
        int dstSample = 1;
        if (sample > dstSample) {
            dstSample = sample;
        }
        options.inJustDecodeBounds = false;
        //设置图片采样率
        options.inSampleSize = dstSample;
        //设置图片解码格式
        options.inPreferredConfig = Bitmap.Config.RGB_565;

        return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(),
                musicPicRes, options), musicPicSize, musicPicSize, true);
    }
 ```
 3:唱盘指针 其实是一张图片，设置它的旋转起始坐标点，监听viewPager的滑动利用ObjectAnimator旋转指针
 ```
  private void initNeedle() {
        mIvNeedle = (ImageView) findViewById(R.id.ivNeedle);

        int needleWidth = (int) (DisplayUtil.SCALE_NEEDLE_WIDTH * mScreenWidth);
        int needleHeight = (int) (DisplayUtil.SCALE_NEEDLE_HEIGHT * mScreenHeight);

        /*设置手柄的外边距为负数，让其隐藏一部分*/
        int marginTop = (int) (DisplayUtil.SCALE_NEEDLE_MARGIN_TOP * mScreenHeight) * -1;
        int marginLeft = (int) (DisplayUtil.SCALE_NEEDLE_MARGIN_LEFT * mScreenWidth);

        Bitmap originBitmap = BitmapFactory.decodeResource(getResources(), R.drawable
                .ic_needle);
        Bitmap bitmap = Bitmap.createScaledBitmap(originBitmap, needleWidth, needleHeight, false);

        LayoutParams layoutParams = (LayoutParams) mIvNeedle.getLayoutParams();
        layoutParams.setMargins(marginLeft, marginTop, 0, 0);

        int pivotX = (int) (DisplayUtil.SCALE_NEEDLE_PIVOT_X * mScreenWidth);
        int pivotY = (int) (DisplayUtil.SCALE_NEEDLE_PIVOT_Y * mScreenWidth);

        mIvNeedle.setPivotX(pivotX);
        mIvNeedle.setPivotY(pivotY);
        mIvNeedle.setRotation(DisplayUtil.ROTATION_INIT_NEEDLE);
        mIvNeedle.setImageBitmap(bitmap);
        mIvNeedle.setLayoutParams(layoutParams);
    }

    private void initObjectAnimator() {
        mNeedleAnimator = ObjectAnimator.ofFloat(mIvNeedle, View.ROTATION, DisplayUtil
                .ROTATION_INIT_NEEDLE, 0);
        mNeedleAnimator.setDuration(DURATION_NEEDLE_ANIAMTOR);
        mNeedleAnimator.setInterpolator(new AccelerateInterpolator());
        mNeedleAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
                /**
                 * 根据动画开始前NeedleAnimatorStatus的状态，
                 * 即可得出动画进行时NeedleAnimatorStatus的状态
                 * */
                if (needleAnimatorStatus == NeedleAnimatorStatus.IN_FAR_END) {
                    needleAnimatorStatus = NeedleAnimatorStatus.TO_NEAR_END;
                } else if (needleAnimatorStatus == NeedleAnimatorStatus.IN_NEAR_END) {
                    needleAnimatorStatus = NeedleAnimatorStatus.TO_FAR_END;
                }
            }

            @Override
            public void onAnimationEnd(Animator animator) {

                if (needleAnimatorStatus == NeedleAnimatorStatus.TO_NEAR_END) {
                    needleAnimatorStatus = NeedleAnimatorStatus.IN_NEAR_END;
                    int index = mVpContain.getCurrentItem();
                    playDiscAnimator(index);
                    musicStatus = MusicStatus.PLAY;
                } else if (needleAnimatorStatus == NeedleAnimatorStatus.TO_FAR_END) {
                    needleAnimatorStatus = NeedleAnimatorStatus.IN_FAR_END;
                    if (musicStatus == MusicStatus.STOP) {
                        mIsNeed2StartPlayAnimator = true;
                    }
                }

                if (mIsNeed2StartPlayAnimator) {
                    mIsNeed2StartPlayAnimator = false;
                    /**
                     * 只有在ViewPager不处于偏移状态时，才开始唱盘旋转动画
                     * */
                    if (!mViewPagerIsOffset) {
                        /*延时500ms*/
                        DiscView.this.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                playAnimator();
                            }
                        }, 50);
                    }
                }
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }
 ```
 #
<img src="https://github.com/PangHaHa12138/MusicPlayer2.0/blob/master/Screenshot/doc1.png" width="300"/> <img src="https://github.com/PangHaHa12138/MusicPlayer2.0/blob/master/Screenshot/doc2.png" width="300"/>

<img src="https://github.com/PangHaHa12138/MusicPlayer2.0/blob/master/Screenshot/doc3.png" width="300"/> <img src="https://github.com/PangHaHa12138/MusicPlayer2.0/blob/master/Screenshot/doc4.png" width="300"/>



