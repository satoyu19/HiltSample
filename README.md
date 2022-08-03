# Hilt(Dependency Injection: DI)

・コードを再利用できる<br>
・リファクタリングが容易になる<br>
・テストが容易になる<br>

### DIを行う主な方法
__________________
   ・コンストラクタ インジェクション：クラスの依存関係をコンストラクタに渡します。<br>
   ・フィールド インジェクション（またはセッター インジェクション）：アクティビティやフラグメントなど、一部の Android フレームワーク クラスはシステムによってインスタンス化されるため、コンストラクタ インジェクションは不可能です。フィールド インジェクションでは、クラスの作成後に依存関係がインスタンス化されます。次のようなコードを使用します。<br>
   
### Hiltの利点(自動DI)
__________________
・ボイラープレートの削減<br>
・分離されたビルドの依存関係<br>
・簡略化された構成<br>
・改善されたテスト<br>
・標準化されたコンポーネント<br>

参考URl:https://dagger.dev/hilt/benefits
      　：https://qiita.com/takahirom/items/3231edf2a430569b3e9d

### Hilt概要
__________________
参考URL：https://developer.android.com/training/dependency-injection/hilt-android?hl=ja#component-bindings<br>
Hilt は、対応する Android クラスのライフサイクルに従って、生成されたコンポーネント クラスのインスタンスを自動的に作成、破棄します。<br>
例：FragmentComponent　→　作成のタイミング：Fragment#onAttach()  破棄のタイミング：Fragment#onDestroy()<br>
参考URL：https://developer.android.com/training/dependency-injection/hilt-android?hl=ja#component-lifetimes<br>

さまざまな型のインスタンスを提供する方法について Hilt が持っている情報はバインディングとも呼ばれる。今回の場合には、DataFormatterとLoggerLocalDataSourceの二つのバインディングがある。<br>

#Hiltモジュール　
Hilt にバインディングを追加するために使用される。コンストラクタで注入できない型(インターフェース等)にバインディングを追加できる。Hilt モジュールは、@Module と @InstallIn のアノテーションが付けられたクラス。@Module はこれがモジュールであることを Hilt に指示し、@InstallIn は Hilt コンポーネントを指定することでバインディングを使用できるコンテナを Hilt に指示する。Hilt で注入できる Android クラスごとに、関連付けられた Hilt コンポーネントがある。<br>

例；Applicationコンテナ　→ ApplicationComponent<br>
   Fragmentコンテナ　→ FragmentComponent <br>
   
### アノテーション
_________________

・@HiltAndroidAppp：アプリのライフサイクルにアタッチされたコンテナを追加<br>

・@AndroidEntryPoint：Android クラスのライフサイクルに沿った依存関係コンテナが作成。付与したクラスで自動DIが可能となる<br>

・@Inject(注入される側):注入したいフィールドに付与することで、Hiltが様々なインスタンスを注入する事ができる。privateは付与できない。(フィールド注入）<br>

・@Inject(注入する側)：特定の型のインスタンスを提供する方法を Hint に指示するには、注入させるクラスのコンストラクタに @Inject アノテーションを追加する。<br>

・@Module:コンストラクタで注入できない型（プロジェクトに含まれていないインターフェースやクラスなど）にバインディングを追加できる。<br>

・@InstallIn：Hilt コンポーネントを指定することでバインディングを使用できるコンテナを Hilt に指示する。Hiltコンポーネントはコンテナと考える事ができる。

・＠Povides：コンストラクタで注入できない型を提供する方法を指示。関数の本体は、Hilt がその型のインスタンスを提供する必要があるたびに実行される。つまり、関数の戻り値を必要とするものに対してDIを行う。

   





