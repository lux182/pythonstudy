#coding:utf-8

class TestClass:
    
    def method1(self):
        print("方法1")

def method2(self):
    print("方法2")
def method3(self):
    print("方法3")

TestClass.method2 = method3

test = TestClass()
test.method1() # 方法1
test.method2() # 方法2