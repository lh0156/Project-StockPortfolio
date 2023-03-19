# Project-StockPortfolio

## 2023. 03. 19 일요일 까지의 기록

- 로그인 기능 구현 완료
- 회원가입 기능 구현 완료
- erd 주식, 멤버 테이블 구현 완료(TODO: 코인)

```mermaid
erDiagram
    MEMBER {
        string id
        string name
        string phoneNumber
        string password
    }
    STOCK {
        int id
        string name
        double price
        date purchaseDate
        int quantity
    }
    MEMBER_STOCK {
        string member_id
        int stock_id
        double purchasePrice
        date purchaseDate
        int quantity
    }

    MEMBER ||--|{ MEMBER_STOCK : "다대 다 관계"
    STOCK ||--|{ MEMBER_STOCK : "다대 다 관계"
```
