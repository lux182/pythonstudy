# 调用父类
class Base:
    def say(self):
        print("Base")

class Child(Base):
    def say(self):
        Base.say(self)
        super(Child, self).say()
        print("Child")

child = Child()
child.say()