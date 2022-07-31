#Hilt(Dependency Injection: DI)

・依存関係インジェクション(DI)
___________________
・コードを再利用できる<br>
・リファクタリングが容易になる<br>
・テストが容易になる<br>

###DIを行う主な方法
   ・コンストラクタ インジェクション：クラスの依存関係をコンストラクタに渡します。<br>
   ・フィールド インジェクション（またはセッター インジェクション）：アクティビティやフラグメントなど、一部の Android フレームワーク クラスはシステムによってインスタンス化されるため、コンストラクタ インジェクションは不可能です。フィールド インジェクションでは、クラスの作成後に依存関係がインスタンス化されます。次のようなコードを使用します。<br>
・Hiltの利点(自動DI)
__________________
・ボイラープレートの削減<br>
・分離されたビルドの依存関係<br>
・簡略化された構成<br>
・改善されたテスト<br>
・標準化されたコンポーネント<br>

参考URl:https://dagger.dev/hilt/benefits

・Hilt概要
__________________
参考URL：https://developer.android.com/training/dependency-injection/hilt-android?hl=ja#component-bindings<br>
Hilt は、対応する Android クラスのライフサイクルに従って、生成されたコンポーネント クラスのインスタンスを自動的に作成、破棄します。<br>
例：FragmentComponent　→　作成のタイミング：Fragment#onAttach() 破棄のタイミング：Fragment#onDestroy()<br>
参考URL：https://developer.android.com/training/dependency-injection/hilt-android?hl=ja#component-lifetimes<br>

さまざまな型のインスタンスを提供する方法について Hilt が持っている情報はバインディングとも呼ばれる。今回の場合には、DataFormatterとLoggerLocalDataSourceの二つのバインディングがある。<br>

#Hiltモジュール　
Hilt にバインディングを追加するために使用される。コンストラクタで注入できない型(インターフェース等)にバインディングを追加できる。




