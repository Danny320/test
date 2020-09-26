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
from selenium import webdriver
import time


@ddt
class FooTestCase(unittest.TestCase):
    # cLass 前置条件
    @classmethod
    def setUpClass(cls) -> None:
        print('setUp Class')

    # class 后置条件
    @classmethod
    def tearDownClass(cls) -> None:
        print('tearDown Class')

    # 前置条件
    def setUp(self) -> None:
        self.driver = webdriver.Chrome()
        self.driver.get('http://www.baidu.com')
        self.driver.implicitly_wait(5)
    # 后置条件
    def tearDown(self) -> None:
        self.driver.find_element_by_id('su').click()
        time.sleep(5)
        self.driver.quit()

    @data('张杰','杨颖')
    def test_1(self,value):
        self.driver.find_element_by_id('kw').send_keys(value)

    # @data(['DannyL320', '0320dan'])
    # @unpack #解包 装饰器
    # def test_1(self, email1, pwd):
    #     driver = webdriver.Chrome()
    #     driver.get('https://mail.163.com/')
    #     driver.implicitly_wait(5)
    #     form = driver.find_element_by_id('x-URS-iframe1598070417863.711')
    #     driver.switch_to.frame(form)
    #     driver.find_element_by_name('email').send_keys('email1')
    #     driver.find_element_by_name('password').send_keys('pwd')
    #     driver.find_element_by_id('dologin').click()
    #     time.sleep(5)



    # def read_file(self):
    #     file = open('111', 'r', encoding='utf8')
    #     li = []
    #     for line in file.readlines():
    #         print(line)
    #         li.append(line.strip('\n').split(','))
    #         for l in li:
    #             print(l)
    #     file.close()
    #     return li


    # def test_1(self):
    #     self.read_file()






if __name__ == '__main__':
    unittest.main()





