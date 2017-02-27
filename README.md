# ShapeFlyer

![demo](screenshots/shapeflyer-chaos.gif)

![demo](screenshots/shapeflyer-select.gif)

***

## Installation

Gradle

```groovy
compile 'com.cipherthinkers:shapeflyer:1.0.0'
```

Maven
```xml
<dependency>
  <groupId>com.cipherthinkers</groupId>
  <artifactId>shapeflyer</artifactId>
  <version>1.0.0</version>
  <type>pom</type>
</dependency>
```

## Sample Usage

Here is how you can use it in your layout
```xml
<com.cipherthinkers.shapeflyer.ShapeFlyer
        android:id="@+id/shape_flyer"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:enable_alpha="true"
        app:enable_scale="true" />
```
In your activity, do the following to start the animation:

Create a FlyBluePrint which will be used to define the path along which the animation should occur:
e.g. For creating a linear animation starting from point (0, 0), top-left corner of the ShapeFlyer, to the (1,1), the bottom-right corner of the ShapeFlyer, do the following
```java
FlyBluePrint linearBluePrint = new FlyBluePrint(new FPoint(0, 0), FlyPath.getSimpleLinePath(new FPoint(1,1)));
```

Now to start the animation of a shape, say smiley, using the blueprint you just created, do the following:
```java
ShapeFlyer mShapeFlyer = (ShapeFlyer) findViewById(R.id.shape_flyer);
mShapeFlyer.startAnimation(R.drawable.smiley, linearBluePrint);
```
You can create any kind of path using the FlyPath class to create the animation. Please refer to the samples provided along with the library in the "shapeflyer-sample" module. 

##License

```ShapeFlyer``` is released under Apache 2.0 license.
