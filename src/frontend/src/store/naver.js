import axios from 'axios'
import router from '@/router'
const state = {
    context: `http://localhost:5000/`,
    navermovie: [],
    count: 0
}
const actions = {
    async search({ commit }, searchWord){
        alert("검색어 " + searchWord)
        axios.get(state.context+"navermovie/" + searchWord)
            .then(({data})=>{
                alert('서버 연결.' + data)
                commit('SEARCH', data)
                router.push("/navermovie")
            })
            .catch(()=>{
                alert('네이버 통신 실패')
            })
    }
}
const mutations = {
    SEARCH(state, data){
        alert('뮤테이션 진입')
        state.navermovie = []
        state.count = data.count
        data.list.forEach(
            item => {
                state.navermovie.push([item.ac, item.tit3])
            }
        )
    }
}
const getters = {
    navermovie: state => state.navermovie,
    count: state => state.count
}
export default {
    name: 'naver',
    namespaced: true,
    state,
    actions,
    mutations,
    getters
}