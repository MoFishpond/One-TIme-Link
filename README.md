# One-Time-Link
Share a link that is available only one time or variable length of time.

## Dependencies
You need to install the following dependencies to build and run this project.
* `Java8`
* `Maven`
* `Docker`
* `Docker Compose`
* `npm`

## Security Group
You need to open the port 8081, 6374 and 3000 in the inbound rules.

## Quick install
In order to make the life easier, we create an installation script `setup.sh`.
You can simply run this shell script the following and need to replace the `machine_ipv4` with the real ec2 ipv4.
```shell
export BACKEND="http://machine_ipv4:8081"
./setup.sh
```

## Build and run the project step by step
1. Go to the backend directory and run `mvn clean install`.
2. Go to the root path of this project and run `docker-compose up -d`.
Now the backend service and redis service will be up at the backend.
   
3. Go to the frontend directory and run `npm install`.
After installing all the dependencies, you can run `REACT_APP_BACKEND_URL="http://machine_ipv4:8081" npm start`.
Remember to replace `machine_ipv4` to the ec2 public ipv4.
   
4. Now the frontend is up. You can open `http://machine_ipv4:3000` in your browser and try it!