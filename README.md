# Project-StockPortfolio

## 2023. 03. 19 일요일 까지의 기록

- 로그인 기능 구현 완료
<img width="1478" alt="image" src="https://user-images.githubusercontent.com/62834176/226159681-52acdda2-f5d6-4d93-a9e5-57ee630b6480.png">
- 회원가입 기능 구현 완료
<img width="1339" alt="image" src="https://user-images.githubusercontent.com/62834176/226159695-f826611e-b1fa-425f-8e13-14b7ed2db316.png">
- erd 주식, 멤버 테이블 구현 완료(TODO: 코인)

erDiagram
    MEMBER {
        int id
        string name
        string email
        string password
    }
    STOCK {
        int id
        string name
        string code
        int quantity
    }
    MEMBER_STOCK {
        int member_id
        int stock_id
        decimal purchase_price
        date purchase_date
        int quantity
    }

    MEMBER ||--|| MEMBER_STOCK
    STOCK ||--|| MEMBER_STOCK
