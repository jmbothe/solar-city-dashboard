
FROM node:latest

# Create app directory
RUN mkdir -p /dashboard
WORKDIR /dashboard

COPY package.json /dashboard

RUN npm install

CMD [ "npm", "start" ]