#!/bin/bash

PATH_OF_ME=$1
OUT_FILE=${PATH_OF_ME}/Contents/Resources/Java/java_info.txt
echo "SHELL:" ${SHELL} > ${OUT_FILE}
echo "PATH_OF_ME:" ${PATH_OF_ME} >> ${OUT_FILE}
if [ "${JAVA_HOME}" == "" ]; then
  . ./setjava.sh
fi
echo "JAVA_HOME:" ${JAVA_HOME} >> ${OUT_FILE}

if [ "${JAVA_HOME}" != "" ]; then
  JAVA_VERSION=$("${JAVA_HOME}"/bin/java -version 2>&1 | grep version)
  echo "JAVA_VERSION:" ${JAVA_VERSION} >> ${OUT_FILE}
  cd ${PATH_OF_ME}/Contents/Resources/Java/
  "${JAVA_HOME}"/bin/java -jar nomad.jar
fi
