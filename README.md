# MultiProgressBar
A beautiful,  Android Multi ProgressBar.

## How to use
Inside your GRADLE (APP) add :

```
dependencies{
compile 'com.github.mohak1712:MultiProgressBar:2.3.1'
}
```
```
allprojects {
    repositories {
        maven { url "https://jitpack.io" }
    }
}

```

In XML--
```
    xmlns:custom="http://schemas.android.com/apk/res-auto" -  parent layout
    
 <com.mohak.mutliprogressbar.MultiProg
        android:id="@+id/mutli"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        custom:barHeight="2dp"
        custom:mReachedBarColor="#d3d"
        custom:mColorLeft="#ffffff"
        custom:mColorRight="#ffffff"
        android:layout_margin="10dp"
        custom:mBgcolor="#e9e9e9"
        custom:maxprogress="100"
        custom:textsize="10sp"
        custom:progress="50" />
```

**NOTE -** mBgcolor should be same as background color of your parent layout
In JAVA--

```       
        multiProg = (MultiProg) findViewById(R.id.mutli);
        multiProg.setmCurrentProgress(15);
```               
        
![screenshot_20160802-171737](https://cloud.githubusercontent.com/assets/12782512/17327445/ae2dc0d4-58d5-11e6-8fbb-0b3dbd4da5cf.png)
![screenshot_20160802-171740](https://cloud.githubusercontent.com/assets/12782512/17327446/aecc646e-58d5-11e6-8c23-add1003634f4.png)
![screenshot_20160802-171745](https://cloud.githubusercontent.com/assets/12782512/17327447/b028f2b4-58d5-11e6-8632-235b49b5a126.png)
![screenshot_20160802-171748](https://cloud.githubusercontent.com/assets/12782512/17327448/b0f678a6-58d5-11e6-8c08-44519b6312ba.png)
![screenshot_20160802-171751](https://cloud.githubusercontent.com/assets/12782512/17327450/b24fddaa-58d5-11e6-8cbd-5986007701a4.png)


        
        
