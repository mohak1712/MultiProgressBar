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
        android:layout_margin="10dp"
        custom:maxprogress="200"
        custom:textsize="10sp"
        custom:progress="100" />
```
In JAVA--

```       
        multiProg = (MultiProg) findViewById(R.id.mutli);
        multiProg.setmCurrentProgress(15);
        
        
        
