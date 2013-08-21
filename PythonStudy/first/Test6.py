class TestClass:
    def method(self):
        print("测试方法")

test = TestClass()
print(TestClass.method) #<unbound method TestClass.method>
print(test.method) #<bound method TestClass.method of <__main__.TestClass object at 0x021B46D0>>

TestClass.method(test) #测试方法
test.method() #测试方法