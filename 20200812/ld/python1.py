# coding = utf-8
from selenium import webdriver
import time
browser = webdriver.Chrome()
browser.get("http://www.baidu.com")
#######百度输入框的定位方式########
# print("浏览器最大化")
# browser.maximize_window()
# time.sleep(2)
# browser.find_element_by_id("kw").send_keys("hahaha")
# browser.find_element_by_id("su").click()
# time.sleep(3)
# browser.find_element_by_name("wd").clear()
# time.sleep(3)
# browser.find_element_by_name("wd").send_keys("杨冬是傻逼吗")
# browser.find_element_by_id("su").submit()
# time.sleep(3)
# browser.quit()

#link text
# browser.find_element_by_link_text("视频").click()
# time.sleep(6)
# browser.find_element_by_name("wd").clear()
# time.sleep(3)
# browser.find_element_by_mane("wd").send_keys()

# test = browser.find_element_by_id("bottom_layer").text
# print("text = "+test)
# browser.quit()

browser.find_element_by_id("kw").send_keys("周深")
browser.find_element_by_id("su").submit()
browser.implicitly_wait(10)
browser.find_element_by_link_text("周深_百度百科").click()
title = browser.title
print(title)
print(browser.current_url)
time.sleep(6)
