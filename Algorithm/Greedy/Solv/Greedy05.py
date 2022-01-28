### 코드업 최소대금
### https://codeup.kr/problem.php?id=2001

pasta = []
for i in range(3):
    pasta.append(float(input()))

juice = []
for i in range(2):
    juice.append(float(input))

result = (min(pasta) + min(juice)) * 1.1
print(format(result, ".lf"))
