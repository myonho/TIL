### JetBrainのコード規約
https://kotlinlang.org/docs/reference/coding-conventions.html

### Googleのスタイルガイド
https://android.github.io/kotlin-guides/style.html

### IntelliJヘルプページ
https://pleiades.io/help/idea/install-and-set-up-product.html

### tips
- IntelliJでKotlin/JVMを選択すると、KotlinのコードのtargetがJVMになる
- Kotlinが動く仕組み
    - コンパイル→バイトコードに変換（kotlinc-jvm）→JVM上で実行

### Kotlin REPL
- Tools/Kotlin/Kotlin REPL/
    - read, evaluate, print, loop...console.logみたいなことができる
    
### バイトコードを確認する
- shift*2->show kotlinで検索->バイトコードウィンドウが表示される
- DecompileするとJVM用にKotlinコンパイラが作成したバイトコードがJavaに逆コンパイルされたコードが表示される

### Javaのプリミティブ型と参照型
- int(primitive) Integer(reference type) 後者はソースコード内で定義される
    - ジェネリクスなどはprimitiveでは使えない
    - オブジェクト指向機能を使うのに向いている
- Kotlinは参照型のみ
    - Kotlinコンパイラは状況に応じてJavaのprimitive型に変換する（パフォーマンスの向上）
    - デコンパイルすればわかる
    