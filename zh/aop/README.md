#AOP

传统 AOP 实现需要引入大量繁杂而多余的概念,例如:Aspect、Advice、Joinpoint、Poincut、 Introduction、Weaving、Around 等等,并且需要引入 IOC 容器并配合大量的 XML 或者 annotation 来进行组件装配。
传统 AOP 不但学习成本极高,开发效率极低,开发体验极差,而且还影响系统性能,尤 其是在开发阶段造成项目启动缓慢,极大影响开发效率。
JFinal 采用极速化的 AOP 设计,专注 AOP 最核心的目标,将概念减少到极致,仅有三个 概念:Interceptor、Before、Clear,并且无需引入 IOC 也无需使用繁杂的 XML。
