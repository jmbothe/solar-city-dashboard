FROM node:latest

RUN mkdir -p /dashboard
WORKDIR /dashboard

COPY package.json /dashboard

RUN npm install

CMD [ "npm", "start" ]