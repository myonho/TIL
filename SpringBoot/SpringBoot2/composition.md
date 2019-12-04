### SpringBootの構成
- jarファイル作成できる
    - ```java -jar```で実行するためのファイル SpringBootに組み込まれたtomcatが起動する
- warファイルも作成できる
    - アプリケーションサーバにデプロイする
    
### SpringBootの使い方
それだけで成り立っているという考えはNG
- Spring MVC、SpringBatchと組み合わせて使う
- starter
    - 一連の依存関係をセットとして揃えるためのモジュール
    - ```spring-boot-starter-web```を依存関係に追加したらwebアプリ向けのライブラリをまとめて導入できる
    - ```spring-boot-starter-jdbc```SpringJDBC、tomcat JDBC Poolが追加される
    - 自作できる（```*-spring-boot-starter```の命名規則あり）
    - ```spring-boot```prefixは予約語になっているので使えない
- build-tool
    - 普通のJavaライブラリみたいに```spring-boot-*.jar```をクラスパスに入れると使えるけどbuild-tool使った方がいいよ
    - Apache Maven / Gradle / Antとか
    - Gradle...スクリプトを書けるのでタスクを自由に書ける
        - マルチプロジェクト構成時にサブプロに対して一括設定/個別設定ができる->省記述量
        - SpringBoot2.0.xではGradle4.0以降に対応
            - ```spring-boot-gradle-plugin```をbuild-scriptの依存関係に追加
            - ```spring-boot-gradle-plugin```と```dependency-management```プラグインの利用を宣言する
            - Javaコンパイラ準拠レベルを1.8から11に変更
            - 文字コードUTF-8
            - スターターを依存関係に追加
            - テスト用のスターターをアプリの依存関係に追加
sample：標準的なGradle build-script
```
buildscript{
    ext {
        springBootVersion = "2.0.X"
        groovyVersion = "2.5.X"
    }
    repositories {
        jcenter()
    }
    dependencies {
    classpath "org.springframework.boot:spring-boot-gradle-plugin:${springBootVersion}"
    }
}
    
    apply plugin: "java"
    apply plugin: "org.springframework.boot"
    apply plugin: "io.spring.dependency-management"
    
    sourceCompatibility = 11
    targetCompatibility = 11
    [compileJava, compileTestJava, compileGroovy, compileTestGroovy]*.
    options*.encoding = "UTF-8"
    
    repositories {
        jcenter()
    }
    
    dependencyManagement {
        imports {
            mavenBom org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES
        }
    }
    
    dependencies {
        compile "org.springframework.boot:spring-boot-starter-thymeleaf"
        testCompile "org.springframework.boot:spring-boot-starter-test"
    }
    
}
``` 