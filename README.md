# Annotation

see https://developer.android.google.cn/studio/write/annotations.html?hl=zh-cn#adding-annotations

# 说明

## Android自带的注解

### Nullness 注解

添加 @Nullable 和 @NonNull 注解，以检查给定变量、参数或返回值的 nullness。@Nullable 注解指示可以为 null 的变量、参数或返回值，而 @NonNull 则指示不可为 null 的变量、参数或返回值。

### 资源注解

验证资源类型可能非常有用，因为 Android 对资源（例如可绘制对象和字符串资源）的引用以整型形式传递。需要参数来引用特定类型资源（例如可绘制对象）的代码可以作为预计的引用类型 int 传入，不过实际将引用不同类型的资源，例如 R.string 资源。

### 线程注解

线程注解可以检查某个方法是否从特定类型的线程调用。支持以下线程注解：

@MainThread
@UiThread
@WorkerThread
@BinderThread
@AnyThread

### 值约束注解
使用 @IntRange、@FloatRange 和 @Size 注解可以验证传递的参数的值。在应用到用户可能弄错其范围的参数时，@IntRange 和 @FloatRange 都非常有用。

### 权限注解
使用 @RequiresPermission 注解可以验证方法调用方的权限。要检查有效权限列表中是否存在某个权限，请使用 anyOf 属性。要检查是否存在一组权限，请使用 allOf 属性。下面的示例会标注 setWallpaper() 方法，以确保方法的调用方拥有 permission.SET_WALLPAPERS 权限：

### 返回值注解

使用 @CheckResult 注解可以验证实际使用的是方法的结果还是返回值。添加注释来阐明可能令人困惑的方法的结果，而不是使用 @CheckResult 标注每个非空方法。例如，新 Java 开发者经常误认为 <String>.trim() 会移除原始字符串中的空格。使用 @CheckResult 标注方法会在调用方未对方法返回值作任何处理的地方标记 <String>.trim() 的使用。

### CallSuper 注解

使用 @CallSuper 注解可以验证替换方法是否会调用方法的超类实现。下面的示例会标注 onCreate() 方法，以确保任何替换方法实现都会调用 super.onCreate()：

### Typedef 注解


使用 @IntDef 和 @StringDef 注解，以便能够创建整型和字符串集的枚举注解来验证其他类型的代码引用。Typedef 注解可以确保特定参数、返回值或字段引用特定的常量集。它们还可以完成代码以自动提供允许的常量。

@IntDef(flag=true, value={
        DISPLAY_USE_LOGO,
        DISPLAY_SHOW_HOME,
        DISPLAY_HOME_AS_UP,
        DISPLAY_SHOW_TITLE,
        DISPLAY_SHOW_CUSTOM
})


