const base = {
    get() {
                return {
            url : "http://localhost:8080/springbootwwiwn/",
            name: "springbootwwiwn",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springbootwwiwn/front/index.html'
        };
            },
    getProjectName(){
        return {
            projectName: "人才面试管理系统"
        }
    }
}
export default base
