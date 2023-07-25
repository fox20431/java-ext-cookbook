# Tomcat

## 开发环境运行

Edit `run configuration`, add `tomcat server` and configure the application server(add the path of tomcat). Then set deployment, add the artifact name `xxx-war(exploded)`.

* `exploded` is the exploded war file, which is the directory of the war file.

## 生产环境运行

使用Gradle构建工具构建war包：

```shell
./gradlew :tomcat:build
```

将再 `tomcat` 目录下生成 `./build/libs/xxx.war` 文件。

将 `tomcat.war` 文件拷贝到 `tomcat` 的 `webapps` 目录下，启动tomcat：

```shell
$TOMCAT_HOME/bin/catalina.sh start
```

war包将自动解压，访问URL的时候记得加上路径。


