#定义一个类，实现加减乘除算法
#对该类中的加减乘除进行单元测试（加法实现对不对）
class mymath():
    def add(self, a, b):
        return a + b

    def jian(self, a, b):
        return a - b

    def cheng(self, a, b):
        return a*b

    def chu(self, a, b):
       return a / b

if __name__ == "__main__":
    mm = mymath()
    ac = mm.add(2,3)
    ex = 5
    if ac == ex:
        print("该加法功能实现正确")