docker build -t  abc-account-service ./abc-account-service
docker build -t  abc-billing-service ./abc-billing-service
docker build -t  abc-catalog-service ./abc-catalog-service
docker build -t  abc-gateway-server ./abc-gateway-server
docker build -t  abc-order-service ./abc-order-service
docker build -t  abc-payment-service ./abc-payment-service
docker build -t  abc-frontend ./abc-frontend
docker tag abc-account-service  halilcakmak34/abc-account-service
docker tag abc-billing-service  halilcakmak34/abc-billing-service
docker tag abc-catalog-service  halilcakmak34/abc-catalog-service
docker tag abc-gateway-server  halilcakmak34/abc-gateway-server
docker tag abc-order-service  halilcakmak34/abc-order-service
docker tag abc-payment-service halilcakmak34/abc-payment-service
docker tag abc-frontend  halilcakmak34/abc-frontend
docker tag hashicorp/consul  halilcakmak34/consul
docker push  halilcakmak34/abc-account-service
docker push  halilcakmak34/abc-billing-service
docker push  halilcakmak34/abc-catalog-service
docker push  halilcakmak34/abc-gateway-server
docker push  halilcakmak34/abc-order-service
docker push  halilcakmak34/abc-payment-service
docker push  halilcakmak34/abc-frontend
docker push  halilcakmak34/consul
