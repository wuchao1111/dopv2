// 配置所有接口的API文件

const host = "http://open.dop.clsaa.com";
// const host = "http://localhost:8888";
const pipeline = "/pipeline-server";
const application = "/application-server";
const permission = "/permission-server";
const code = "/code-server";
const user = "/user-server";
const image = "/image-server";
const test = "/test-server";
const link = "/link-server";

const API = {
    address: "http://www.dop.clsaa.com/#/",
    // address: "http://localhost:3000/#/",
    gateway: host,
    pipeline: host + pipeline,
    application: host + application,
    permission: host + permission,
    code: host + code,
    user: host + user,
    image: host + image,
    test: host + test,
    link: "http://localhost:14300"
};

export default API;
