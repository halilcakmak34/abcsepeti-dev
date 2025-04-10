FROM nginx:1.19.0
WORKDIR /usr/share/nginx/html
RUN rm -rf ./*
COPY ./build .
ENTRYPOINT ["nginx", "-g", "daemon off;"]