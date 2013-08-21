# 私有成员
class TestClass:
    __private_property = 1

    def __private_method(self):
        pass

print(TestClass.__dict__) # {'__module__': '__main__', '_TestClass__private_method': <function __private_method at 0x0212B970>, '_TestClass__private_property': 1