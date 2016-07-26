# MultiProgressBar
A beautiful,  Android Multi ProgressBar.

## How to use
Inside your GRADLE (APP) add :

```
dependencies{
compile 'com.github.mohak1712:MultiProgressBar:1.0'
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
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        custom:barHeight="2dp"
        custom:mReachedBarColor="#d3d"
        android:id="@+id/mutli"
        mohak:mColorLeft="#ffffff"
        mohak:mColorRight="#ffffff"
        android:layout_margin="10dp"
        custom:maxprogress="200"
        custom:textsize="10sp"
        custom:progress="100" />
```
In JAVA--

```       
        multiProg = (MultiProg) findViewById(R.id.mutli);
        multiProg.setmCurrentProgress(15);
```               
        
 ![multiprog1](https://cloud.githubusercontent.com/assets/12782512/17131979/5e14eac0-533d-11e6-9832-4f8da2ece5c6.png)
 
![multiprog2](https://cloud.githubusercontent.com/assets/12782512/17131981/604f9e0c-533d-11e6-993c-14832b867808.png)

![multiprog3](https://cloud.githubusercontent.com/assets/12782512/17131983/611b6230-533d-11e6-9b3b-1e3356dbd1fb.png)

![multiprog4](https://cloud.githubusercontent.com/assets/12782512/17131985/61d87b04-533d-11e6-9d90-880ec64536a5.png)

![multiprog5](https://cloud.githubusercontent.com/assets/12782512/17131986/62c56f4a-533d-11e6-9d3b-bb05ca8bb646.png)

        
        
