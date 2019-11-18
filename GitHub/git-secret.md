## 久しぶりに自宅PCを使ったらgit-commitができなくなっていた

### 前提
- 大昔に勉強のためawsに自作サイトをupしていた
- awsの鍵などpushしちゃったら大惨事なので、git-secretを導入していた
- 無料枠失効のタイミングでawsのアカウントは削除、リモートリポジトリも削除した
- またhomebrewでインストールしていたので
```
$ brew remove git-secrets
```
でgit-secretを削除していた
- 久しぶりにgit-commitしようとしたら
```git: 'secrets' is not a git command. See 'git --help'.```
ってメッセージが出てきてコミットに失敗した

### 原因
- 操作対象リポジトリ（TILリポジトリ）が`commit実行時にgit-secretsを利用する設定になっていた

### これで解決
- ```.git/hooks```内の実行ファイル、```commit-msg```, ```pre-commit```, ```prepare-commit-msg```に設定が残っていたので、これらを削除した

### 参考
[git secretsを削除する時の注意](https://piruty2.hatenablog.jp/entry/%3Fp%3D521) by piruty’s blog
