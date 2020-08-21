# from selenium import webdriver
# # driver = webdriver.Chrome()
# # driver.get('http://www.baidu.com')
# # print(driver.title)
# # driver.quit()


# 无界面模式
# from selenium import webdriver
# from selenium.webdriver.chrome.options import Options # 选择参数
# options = Options()
# driver = webdriver.Chrome(chrome_options=options)
# driver.get("https://wwww.hao123.com")
# print(driver.title)
# driver.quit()


# 自动化测试元素如何定位
# import time
#
# from selenium import webdriver
# driver = webdriver.Chrome()
# driver.get('http://www.baidu.com')
# time.sleep(3)
# driver.maximize_window() #窗口最大化
# time.sleep(3)
# in_put = driver.find_element_by_id(id_='kw').send_keys('机器人')
# driver.find_element_by_link_text('设置').click()
# time.sleep(3)
# driver.find_element_by_link_text('隐私设置')
# time.sleep(3)
# driver.quit()


# 表单   自动化测试工具selenium-->表单上面
import ddt as ddt
# from selenium import webdriver
# import time
# driver = webdriver.Chrome()
# driver.get('http://www.baidu.com')
# # 浏览器解析服务端返回的数据需要时间
# driver.implicitly_wait(5)
# form = driver.find_element_by_id('x-URS-iframe')
# driver.switch_to.frame(form)
# driver.find_element_by_name('email').send_keys('DannyL0320')
# driver.find_element_by_name('password').send_keys('0320dan')
# time.sleep(6)


# ddt 使用
import unittest
from ddt import ddt, data, file_data, unpack


@ddt
class FooTestCase(unittest.TestCase):
    from selenium import webdriver
    import time
    driver = webdriver.Chrome()
    driver.get('http://www.baidu.com')
    @data("lisa", "张杰", "杨幂", "杨颖")
    def test_baidu2(self, value):
        driver = self.driver
        driver.get(self.base_url + "/")
        driver.find_element_by_id("kw").send_keys(value)
        driver.find_element_by_id("su").click()

