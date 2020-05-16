# -*- coding: utf-8 -*-


class NQueen:
    result = []
    cols = set()
    pie = set()
    na = set()

    def queen(self, n):
        if n < 1:
            return []

        self.dfs(n, 0, [])

        return self.result

    def dfs(self, n, row, cur_state):
        if row >= n:
            self.result.append(cur_state)
            return

        for col in range(n):
            if col in self.cols or row + col in self.pie or col-row in self.na:
                continue

            self.cols.add(col)
            self.pie.add(row+col)
            self.na.add(col-row)

            self.dfs(n, row+1, cur_state+[col])

            self.cols.remove(col)
            self.pie.remove(row + col)
            self.na.remove(col-row)

    def print_result(self, n):
        for res in results:
            for i in res:
                for j in range(n):
                    if i == j:
                        print("Q", end=" ")
                    else:
                        print("*", end=" ")
                print()
            print()


if __name__ == '__main__':
    q = NQueen()
    results = q.queen(4)
    q.print_result(4)

    l1 = []
    l2 = [3]
    print(l1.append(l2))
