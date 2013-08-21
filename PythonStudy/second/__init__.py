def getName(name):
    return'{0}-{1}-{2}'.format(name[4:8], name[8:10],name[10:12])
var = getName('IMG_21030820_1232132.jpg')
print(var)

s='one,two,three'
s.split(',')
print(s)

l=['one','tow','three']
','.join(l)
print(l)

path_in=r'D:\test_in.txt'
path_out=r'D:\test_out.txt'
f_in=open(path_in)
f_out=open(path_out,'w')
for i in f_in.readlines():
    if 'a' in i:
        f_out.write(i.replace('a','sss'))
    else:
        f_out.write(i)
f_in.close()
f_out.close()
