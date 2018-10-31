# 用于存放基础类库脱离于业务逻辑的类库

+ 依赖 com.asa.third
+ [开发计划](src/main/resources/TODO.MD)
+ 最好的demo就是看test的写法
+ com.asa.dev里面是正在开发的的功能
+ 涉及到改动代码的pr记得在.git/hooks里面添加运行所有单元测试，所有单元测试通过才能提交
```
#! /bin/bash

# save the file as <git_directory>/.git/hooks/pre-commit

echo "Running Maven clean test for errors"
# retrieving current working directory
CWD=`pwd`
MAIN_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
# go to main project dir
cd $MAIN_DIR/../../
# running maven clean test
/usr/local/bin/mvn clean test
if [ $? -ne 0 ]; then
  "Error while testing the code"
  # go back to current working dir
  cd $CWD
  exit 1
fi
# go back to current working dir
cd $CWD
```
