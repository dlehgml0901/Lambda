<template>
    <div>
        <h3>검색결과 : {{count}}</h3>
        <v-simple-table>
            <template v-slot:default>
                <thead>
                <tr>
                    <th class="text-left">No.</th>
                    <th class="text-left">이미지</th>
                    <th class="text-left">노래제목</th>
                    <th class="text-left">가 수</th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="item in bugsmusic" :key="item">
                    <td>{{ item[0] }}</td>
                    <td><img :src="item[1]"></td>
                    <td>{{ item[2] }}</td>
                    <td>{{ item[3] }}</td>
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
                bugsmusic: state => state.crawling.bugsmusic,
                count: state => state.crawling.count
            })
        }
    };
</script>

<style scoped>

</style>