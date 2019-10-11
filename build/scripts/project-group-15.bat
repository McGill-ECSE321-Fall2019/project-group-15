@rem
@rem Copyright 2015 the original author or authors.
@rem
@rem Licensed under the Apache License, Version 2.0 (the "License");
@rem you may not use this file except in compliance with the License.
@rem You may obtain a copy of the License at
@rem
@rem      https://www.apache.org/licenses/LICENSE-2.0
@rem
@rem Unless required by applicable law or agreed to in writing, software
@rem distributed under the License is distributed on an "AS IS" BASIS,
@rem WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@rem See the License for the specific language governing permissions and
@rem limitations under the License.
@rem

@if "%DEBUG%" == "" @echo off
@rem ##########################################################################
@rem
@rem  project-group-15 startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

set DIRNAME=%~dp0
if "%DIRNAME%" == "" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%..

@rem Add default JVM options here. You can also use JAVA_OPTS and PROJECT_GROUP_15_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS=

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if "%ERRORLEVEL%" == "0" goto init

echo.
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto init

echo.
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:init
@rem Get command-line arguments, handling Windows variants

if not "%OS%" == "Windows_NT" goto win9xME_args

:win9xME_args
@rem Slurp the command line arguments.
set CMD_LINE_ARGS=
set _SKIP=2

:win9xME_args_slurp
if "x%~1" == "x" goto execute

set CMD_LINE_ARGS=%*

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\lib\project-group-15-0.0.1-SNAPSHOT.jar;%APP_HOME%\lib\spring-boot-devtools-2.1.9.RELEASE.jar;%APP_HOME%\lib\spring-boot-starter-web-2.1.9.RELEASE.jar;%APP_HOME%\lib\spring-boot-starter-json-2.1.9.RELEASE.jar;%APP_HOME%\lib\spring-boot-starter-2.1.9.RELEASE.jar;%APP_HOME%\lib\spring-boot-autoconfigure-2.1.9.RELEASE.jar;%APP_HOME%\lib\spring-boot-2.1.9.RELEASE.jar;%APP_HOME%\lib\spring-boot-starter-tomcat-2.1.9.RELEASE.jar;%APP_HOME%\lib\hibernate-validator-6.0.17.Final.jar;%APP_HOME%\lib\spring-webmvc-5.1.10.RELEASE.jar;%APP_HOME%\lib\spring-web-5.1.10.RELEASE.jar;%APP_HOME%\lib\spring-context-5.1.10.RELEASE.jar;%APP_HOME%\lib\spring-aop-5.1.10.RELEASE.jar;%APP_HOME%\lib\spring-beans-5.1.10.RELEASE.jar;%APP_HOME%\lib\spring-expression-5.1.10.RELEASE.jar;%APP_HOME%\lib\spring-core-5.1.10.RELEASE.jar;%APP_HOME%\lib\spring-boot-starter-logging-2.1.9.RELEASE.jar;%APP_HOME%\lib\javax.annotation-api-1.3.2.jar;%APP_HOME%\lib\snakeyaml-1.23.jar;%APP_HOME%\lib\jackson-datatype-jdk8-2.9.9.jar;%APP_HOME%\lib\jackson-datatype-jsr310-2.9.9.jar;%APP_HOME%\lib\jackson-module-parameter-names-2.9.9.jar;%APP_HOME%\lib\jackson-databind-2.9.9.3.jar;%APP_HOME%\lib\tomcat-embed-websocket-9.0.26.jar;%APP_HOME%\lib\tomcat-embed-core-9.0.26.jar;%APP_HOME%\lib\tomcat-embed-el-9.0.26.jar;%APP_HOME%\lib\validation-api-2.0.1.Final.jar;%APP_HOME%\lib\jboss-logging-3.3.3.Final.jar;%APP_HOME%\lib\classmate-1.4.0.jar;%APP_HOME%\lib\spring-jcl-5.1.10.RELEASE.jar;%APP_HOME%\lib\logback-classic-1.2.3.jar;%APP_HOME%\lib\log4j-to-slf4j-2.11.2.jar;%APP_HOME%\lib\jul-to-slf4j-1.7.28.jar;%APP_HOME%\lib\jackson-annotations-2.9.0.jar;%APP_HOME%\lib\jackson-core-2.9.9.jar;%APP_HOME%\lib\logback-core-1.2.3.jar;%APP_HOME%\lib\slf4j-api-1.7.28.jar;%APP_HOME%\lib\log4j-api-2.11.2.jar

@rem Execute project-group-15
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %PROJECT_GROUP_15_OPTS%  -classpath "%CLASSPATH%" com.ecse321.tutoringApp.tutoringAppApplication %CMD_LINE_ARGS%

:end
@rem End local scope for the variables with windows NT shell
if "%ERRORLEVEL%"=="0" goto mainEnd

:fail
rem Set variable PROJECT_GROUP_15_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
if  not "" == "%PROJECT_GROUP_15_EXIT_CONSOLE%" exit 1
exit /b 1

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega
