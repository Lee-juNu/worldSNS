# World's（ワールドイズ）

このプロジェクトは世界を旅しながら過去に行った掲示板が探しにくいSNSの時間順の特性を解決するために作りました。<br>
それだけではなく今までのその場所に対する人々の思い出を見るこを望んで作りました。<br>



## 0．JavaWebSocekt
ITスクール「ソールデスク」でチームプロジェクトで会ったために学んだSpringを使いながらリアルタイムで処理できるようにJavaWebSocektを非同期で使用しています<br>
[javax.websocket Ver 1.1](https://mvnrepository.com/artifact/javax.websocket/javax.websocket-api/1.1)<br>
これでWebSocketを使いたいチームメンバーは私が用意したWebSocketを使いまだSpringの理解がまだだったメンバーはSpringとAjaxを使う勉強目的のプロジェクトでした<br>



## 1.Indexページ
![MainPage](https://user-images.githubusercontent.com/35514984/197023108-0342fcf2-739c-426d-9852-428edccb734f.png)

最初入ったときに見える画面で右上のログインをクリックすることでログインのモーダルウィンドウが出ます<br>




## 2.ログイン画面
![Login](https://user-images.githubusercontent.com/35514984/197028353-7a1f1f16-b4fc-4473-89c8-e7270a1109ed.png)
モーダルウィンドウを使ってIndexページを簡潔にしログインするときに右上ではなく中央で見ることでユーザーが右を見なくっていいように作りました。<br>



## 3.会員登録画面
![JoinUs](https://user-images.githubusercontent.com/35514984/197023143-19d933e0-9137-44d6-b2b5-0d4c286d06b0.png)

ログインと同じくモーダルウィンドウを使いました<br>
会員情報を<br>
1．ID、PW、電話番号、E-mail<br>
2．名前、ニックネーム、生年月日<br>
3．確認、登録<br>
に分けて作りました。<br>

## 4.メインページ-スクロール
![Page](https://user-images.githubusercontent.com/35514984/197023139-b7a87348-3234-484c-9f38-a8e326bc6a3d.png)
メインページでは私がよく使っていたツイッターをモティーフとして作られました
<br>
スクロールページネーションを使うことで気軽に次のページを読んでくることができます


## ５．メインページ (地図)
![Vector](https://user-images.githubusercontent.com/35514984/197029666-0debc7ca-ae86-4e2d-bc83-b3dc8c0fec1f.png)
地図は拡大しても座標で線を描く＜SVG>タグのVectorイメージを使いました<br>
マウスの座標を中心に拡大、ドラグした分地図の移動には行列を使って対応しています


## ６.メインページ (地図-都市クリック）
![KyotoClick](https://user-images.githubusercontent.com/35514984/197032047-7f943a21-8daf-40c3-8c4c-628bdc89eef6.png)
クリックするとPathにあるCountry-ID、Region-Nameを使い掲示板のSelectには国と都市セッティングされます（日本、京都）<br>
そして京都を選択して上げました掲示板が露出されます


## 7.今後追加する機能機能
チャット<br>
アラム機能<br>
私のパソコンではないAWSで私のパソコンが電源オフになっても接続できるように作る<br>



## 動画ー李準宇担当の掲示板
李準宇担当<br>

JAVAウェブソケットの導入<br>

フロントエンド前半<br>

Spring教えながらバックアップ<br>

掲示板担当人がプロジェクト終わる一週間前にやめて一週間で0から作り直しました具現されてないところもありますがよろしくお願いします<br>

地図担当

動画URL：https://youtu.be/UTJBpduAlhU


## プロジェクトの失敗した理由

### 1．プロジェクトのの計画を立てる前に私が皆のレベルを知るべきだった
対面の方はSpringとか結構理解しているからと断定してWebsocketまでは使ってよさそうと思ったが
途中のコードレビューするときに気づいたのでSpringとJavascriptを教えながらするには一か月は足りない時間であった

リーダーになった人としてコミュニケーションが苦手な人でさえ情報を引き出す能力が必要だと思ったプロジェクトであった．


