from selenium import webdriver
import time

driver = webdriver.Chrome()
driver.get("https://www.baidu.com")
driver.find_element_by_id("kw").send_keys("水浒传")
driver.find_element_by_id("su").submit()
time.sleep(3)
driver.find_element_by_id("kw").clear()
driver.find_element_by_id("kw").send_keys("hahaha")
driver.find_element_by_id("su").submit()
time.sleep(4)
driver.quit()