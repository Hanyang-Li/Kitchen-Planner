<template>
    <div>
        <table>
            <tr>
                <td>Id</td>
                <td>BookName</td>
                <td>Author</td>
            </tr>
            <tr v-for="item in books">
                <td>{{item.id}}</td>
                <td>{{item.name}}</td>
                <td>{{item.author}}</td>
            </tr>
        </table>

    </div>
</template>

<script>
    export default {
        name: "Book",
        data(){
            return{
                msg:"Hello Vue",
                books:[
                    {
                        id: 1,
                        name: 'Java',
                        author: 'lisi'
                    },
                    {
                        id: 2,
                        name: 'Vue',
                        author: 'zhangsan'
                    },
                    {
                        id: 3,
                        name: 'Spring Boot',
                        author: 'wangwu'
                    }


                ]
            }
        },
        created() {
            const _this = this
            axios.get('http://localhost:8181/book/findAll/').then(function (resp) {
                _this.books = resp.data

            })
        }
    }
</script>

<style scoped>

</style>