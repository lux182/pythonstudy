from ctypes import *
i = c_int(45)
print(i.value)
i.value=55
print(i.value)

p = create_string_buffer(10)
print(p.raw)
p.value = b"student"
print(p.raw)
p.value = b"big"
print(p.raw)
