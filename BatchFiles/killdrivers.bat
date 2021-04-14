@echo off
echo cleaning all open chromedrivers.exe
taskkill /IM chromedriver.exe /F
echo cleaning all open chrome.exe
taskkill /IM chrome.exe /F
exit 0