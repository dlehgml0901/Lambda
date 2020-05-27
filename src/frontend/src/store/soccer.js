import axios from 'axios'
import router from '@/router';
const state = {
    context: `http://localhost:5000/`,
    soccer: [],
    count: 0

}
const actions = {
    async search({ commit }, searchWord){
        alert('검색어 : ' + searchWord)
        axios
            .post(state.context + `soccer`, searchWord, {
                authorization: "JWT fefege..",
                Accept: "application/json",
                "Content-Type": "application/json"
            })
            .then(({ data }) => {
                commit("SEARCH", data)
                router.push("/");
            })
            .catch(() => {
                alert('축구 통신 실패 !')
            })
    }
}
const mutations = {
    SEARCH(state, data) {
        alert('검색 결과 수: ' + data.count)
        state.soccer = []
        state.count = data.count
        data.list.forEach(
            /*item => {
                state.soccer.push([])
            }*/
        )
    }
}
const getters = {
    soccer: state => state.soccer,
    count: state => state.count
}
export default {
    name: 'soccer',
    namespaced: true,
    state,
    actions,
    mutations,
    getters
}