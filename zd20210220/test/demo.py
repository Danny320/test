# coding=utf-8
import time

from selenium import webdriver


class demo():
    def k_1(self):
        self.driver = webdriver.Chrome()
        self.driver.get("https://www.taobao.com")
        time.sleep(3)

    def j_2(self):
        self.driver.find_element_by_link_text("聚划算").click()
        time.sleep(2)
        handlers = self.driver.window_handles
        print(handlers)
        self.driver.switch_to.window(handlers[1])
        self.driver.find_element_by_xpath("/html/body/div[1]/section/div/div/div/div[4]/div/div/div[1]/div[1]/a/div[1]/div[1]/span").click()
        time.sleep(3)
        self.driver.back()
        time.sleep(3)
    def h_3(self):
        self.driver.quit()

if __name__ == "__main__":
        aa = demo()
        aa.k_1()
        aa.j_2()
        aa.h_3()
