<template>
    <div>
        <h3>검색결과 : {{count}}</h3>
        <v-simple-table>
            <template v-slot:default>
                <thead>
                <tr>
                    <th class="text-left">순위</th>
                    <th class="text-left">영화명</th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="item in navermovie" :key="item">
                    <td><img :src="item[0]"></td>
                    <td>{{ item[1] }}</td>
                </tr>
                </tbody>
            </template>
        </v-simple-table>
        <div class="text-center">
            <v-pagination v-model="page" :length="15" :total-visible="7"></v-pagination>
        </div>
    </div>
</template>

<script>
    import {mapState} from "vuex";
    export default {
        data () {
            return {
                page: 1,
            }
        },
        computed: {
            ...mapState({
                navermovie: state => state.naver.navermovie,
                count: state => state.naver.count
            })
        }
    }
</script>

<style scoped>

</style>