@echo off
setlocal
cd /d "%~dp0"
where gradle >nul 2>nul
if errorlevel 1 (
 echo Gradle nao encontrado. Instale Gradle 8.11.1 e JDK 17 ou use GitHub Actions.
 pause
 exit /b 1
)
call gradle assembleDebug
if errorlevel 1 (echo Falha na compilacao.& pause& exit /b 1)
echo APK: appuild\outputspk\debugpp-debug.apk
pause
