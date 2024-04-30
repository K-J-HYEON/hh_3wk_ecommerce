### 시나리오에서 동시성 이슈가 발생할 수 있는 비즈니스 로직

### e-커머스 서비스
#### 상품의 재고 차감 및 복원
1. 구현의 복잡도
- 사용자가 A : 결제 성공 이후에 재고가 차감되는 방식 B : 결제 이전에 재고가 차감되는 방식
- A 방식에서 상품의 재고가 3개 있고 
- 1번 사용자가 3개 상품 주문 이후 결제를 진행하고
- 2번 사용자가 같은 상품을 3개 주문 이후에 1번 사용자보다 먼저 결제를 진행하면 재고 3개가 차감되어 재고 없는 상태가 됨.
- 1번 사용자가 결제를 완료했을 때 재고가 부족하다는 에러가 발생

2. 성능

3. 효율성

#### 유저의 포인트 잔액
1. 구현의 복잡도
2. 성능
3. 효율성

[동시성 제어 방식]
#### 낙관적 락
1. 충돌 빈도가 적을 경우 권장
2. 동시 요청 중 한건만 성공해야하는 케이스에 적합
3. DB Lock을 설정해서 동시성 문제를 제어하는 것이 아닌 읽은 시점과 수정 시점의 데이터 변경 여부를 확인해 제어하는 방식
4. 트랜잭션, Lock 설정 없이 데이터 정합성을 보장할 수 있으므로 성능적으로 우위에 있음


#### 비관적 락
1. 충돌 빈도가 많을 경우 권장
2. 동시 요청에서 순차로 진행될 때 성공할 수 있는 요청이라면 성공시키는 케이스에 적합
3. 특정 자원에 대해 Lock 설정으로 선점해 정합성을 보장
4. 공유락, 베타락을 걸고 다른 트랜잭션의 접근을 막음


#### 분산락
1. 유저의 잔액 충전과 사용의 동시 요청을 레디스를 활용하여 제어
2. 분산 시스템에서 서로 다른 서버 인스턴스에 대한 일관된 락을 제공하기 위한 장치
3. 분산락의 핵심은 분산된 서버 / 클러스터 간에도 Lock을 보장
4. key-value 기반 원자성을 이용 - Redis 통해 DB 부하를 최소화하는 Lock 설계