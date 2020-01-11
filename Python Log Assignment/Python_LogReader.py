#Part AB
def PartAB(file_path):

    file1=open(file_path)
    lines=file1.readlines()
    file1.close()

    timestamp = 0
    statpid = 1
    clonepid = 2
    
    for line in lines:
        timestamp += 1
        idx = line.find(' ')
        pid = line[0:idx]
        if 'stat(' in line:
            statpid = pid
            statline = line;
            stattimestamp = timestamp
        elif 'clone(' in line:
            clonepid = pid
            cloneline = line;
            clonetimestamp = timestamp
            if statpid == clonepid:
                print('TIMESTAMP\t LINE')
                print(stattimestamp,'\t\t',statline)
                print(clonetimestamp,'\t\t',cloneline)
                statpid = ''
                statline = ''
                stattimestamp = ''

    return statpid
print('PART A AND B')
print('LOG A ------------------------\n')
PartAB('Log-A.strace')
print('LOG B ------------------------\n')
PartAB('Log-B.strace')

#Part C
def PartC(file_path):

    file1=open(file_path)
    lines=file1.readlines()
    file1.close()

    timestamp = 0
    openpid = 0
    getdentspid = 0
    closepid = 0
    
    for line in lines:
        timestamp += 1
        idx = line.find(' ')
        pid = line[0:idx]
        if 'open(' in line:
            openpid = pid
            openline = line;
            opentimestamp = timestamp
        elif 'getdents(' in line:
            getdentspid = pid
            getdentsline = line;
            getdentstimestamp = timestamp
        elif 'close(' in line:
            closepid = pid
            closeline = line;
            closetimestamp = timestamp
            if openpid == getdentspid == closepid:
                print('TIMESTAMP\t LINE')
                print(opentimestamp,'\t\t',openline)
                print(getdentstimestamp,'\t\t',getdentsline)
                print(closetimestamp,'\t\t',closeline)
                openpid = ''
                openline = ''
                opentimestamp = ''

    return openpid

print('PART C')
print('LOG A ------------------------\n')
PartC('Log-A.strace')
print('LOG B ------------------------\n')
PartC('Log-B.strace')

