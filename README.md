## Security

### 基本機能

| 機能     | 説明                                                         |
| -------- | ------------------------------------------------------------ |
| 認証機能 | アプリケーションを利用するユーザーの正当性を確認する機能を提供する |
| 認可機能 | アプリケーションを提供するリソースや処理に対するアクセスを制御する機能を提供する |

### 強化機能

| 機能                                       | 説明                                                         |
| ------------------------------------------ | ------------------------------------------------------------ |
| セッション管理機能                         | セッションハイジャック攻撃やセッション固定攻撃からユーザーを守る機能、セッションのライフサイクル（生成、破棄、タイムアウト）を制御するための機能などを提供する |
| CSRF対策機能                               | クロスサイトリクエストフォージェリ(Cross-Site Request Forgery:CSRF)攻撃からユーザーを守るための機能を提供する |
| ブラウザのセキュリティ対策機能との連携機能 | ブラウザのセキュリティ機能と連携し、ブラウザの機能を悪用した攻撃からユーザーを守るためのセキュリティヘッダーを出力する機能を提供する |



### モジュール

| モジュール名            | 説明                                                         |
| ----------------------- | ------------------------------------------------------------ |
| spring-security-core    | 認証と認可機能を実現するためのコアなコンポーネントが格納されている |
| spring-security-web     | Webアプリケーションのセキュリティ機能を実現するためのコンポーネントが格納されている |
| spring-security-config  | 各モジュールから提供されているコンポーネントのセットアップをサポートするためのコンポーネント(Java ConfigをサポートするクラスやXMLネームスペースを解析するクラスなど)が格納されている |
| spring-security-taglibs | 認証情報や認可機能にアクセスするためのJSPタグライブラリが    |

### 主要コンポーネント

#### FilterChainProxy

FilterChainProxyは、フレームワーク処理のエントリポイントとなるサーブレットフィルタークラスです。このクラスはフレームワーク処理の全体の流れを制御し具体的なセキュリティ処理はSecurity Filterに以上するスタイルになっています。

#### HTTPFirewall

HTTPFirewallインターフェースはHttpServletRequestとHttpServletResponseに対してファイアーウォール機能を組み込むためのインターフェースです。デフォルトではDefaultHttpFirewallクラスが使用されディレクトリトラバーサル攻撃や不正なリダイレクト先の指定によるHTTPレスポンス分割攻撃に対するチェックなどが実装されています。

#### SecurityFilterChain

SecurityFilterChainインターフェースはFilterChainProxyが受け取ったリクエストに対して適用する「Security Filterのリスト」を管理するためのインターフェースです。デフォルトではDefaultSecurityFilterChainが使用され、リクエストごとに「Security Filterのリスト」を管理します。

#### Security Filter

コアなSecurity Filter

| SecurityContextPersistenceFilter     | 認証情報を陸エスをまたいで共有するための処理を提供する。デフォルトの実装では、HttpSessionに認証情報を格納して認証情報を共有する |
| ------------------------------------ | ------------------------------------------------------------ |
| UsernamePasswordAuthenticationFilter | リクエストパラメータで指定されたユーザー名とパスワードを使用して認証処理を行う。フォーム認証を行う際に使用する |
| LogoutFilter                         | ログアウト処理を行う                                         |
| FilterSecurityInterceptor            | HTTPリクエスト(HttpServletRequest)に対して認可処理を実行する |
| ExceptionTransalationFilter          | FilterSecurityInterceptorで発生した例外をハンドリングしてクライアントへ返却するレスポンスを制御する。デフォルトの実装では未認証ユーザーからのアクセスの場合は認証を促すレスポンス、認証済みのユーザーからのアクセスの場合は認可エラーを通知するレスポンスを返却する |



### リンク

* [Spring Security Reference](https://docs.spring.io/spring-security/site/docs/current/reference/htmlsingle/)
* [6\.1\. Spring Security概要 — TERASOLUNA Server Framework for Java \(5\.x\) Development Guideline 5\.1\.0\.RELEASE documentation](https://terasolunaorg.github.io/guideline/5.1.0.RELEASE/ja/Security/SpringSecurity.html)
* [Getting Started · Securing a Web Application](https://spring.io/guides/gs/securing-web/)
* Spring徹底入門

