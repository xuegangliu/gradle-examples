# gradle-examples

gradle构建项目练习

[![License](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)
[![PRs Welcome](https://img.shields.io/badge/PRs-welcome-brightgreen.svg)](https://github.com/xuegangliu/gradle-examples/pulls)
[![GitHub stars](https://img.shields.io/github/stars/xuegangliu/gradle-examples.svg?style=social&label=Stars)](https://github.com/xuegangliu/gradle-examples)
[![GitHub forks](https://img.shields.io/github/forks/xuegangliu/gradle-examples.svg?style=social&label=Fork)](https://github.com/xuegangliu/gradle-examples)

## 目录结构

``` lua
gradle-examples
├── helloworld -- 基础
    ├──src     -- 源码
    ├──build.gradle -- gradle构建配置
├── dependency -- 依赖
├── web -- web项目
├── img -- 图片
├ build.gradle --全局配置
├ settings --模块配置
├ LICENSE
```

## docker部署

修改`build.gradle`配置

## docker mysql容器
`docker pull xuegangliu/lxg-mysql57:latest`
用户名：root
免密：lxgmysql

## 执行

`gradle deploy`