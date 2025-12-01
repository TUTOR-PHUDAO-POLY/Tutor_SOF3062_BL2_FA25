// liet ke cac API theo phia BE
const API = 'http://localhost:8080/api/ca-si/management'

// check
// GET ALL
export const getDanhSachCaSi = async () => {
  const res = await fetch(API)
  if (!res.ok) {
    throw new Error('Load du lieu ca si bi fail')
  }
  return await res.json()
}

// Phan trang
// method: Không truyền phương http nào thì default hiểu là GET
export const phanTrangDanhSachCaSi = async (pageNo, pageSize) => {
  // muon truyen them gia tri tren duong dan: ${ten bien}
  const res = await fetch(`${API}/phan-trang?pageNo1=${pageNo}&pageSize1=${pageSize}`)
  if (!res.ok) {
    throw new Error('Load du lieu ca si bi fail')
  }
  return await res.json()
}
// http://localhost:8080/api/ca-si/management/delete/{{id1}}
export const deleteCaSi = async (id) => {
  // muon truyen them gia tri tren duong dan: ${ten bien}
  const res = await fetch(`${API}/delete/${id}`, {
    method: 'DELETE',
  })
  if (!res.ok) {
    throw new Error('Load du lieu ca si bi fail')
  }
}

export const detailCaSi = async (id) => {
  // muon truyen them gia tri tren duong dan: ${ten bien}
  const res = await fetch(`${API}/detail/${id}`)
  if (!res.ok) {
    throw new Error('Load du lieu ca si bi fail')
  }
  return await res.json()
}

// http://localhost:8080/api/ca-si/management/add
export const addCaSi = async (data) => {
  const res = await fetch(`${API}/add`, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(data),
  })
  if (!res.ok) {
    throw new Error('add du lieu ca si bi fail')
  }
  return null // Do BE k return
}

export const updateCaSi = async (data, id) => {
  const res = await fetch(`${API}/update/${id}`, {
    method: 'PUT',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(data),
  })
  if (!res.ok) {
    throw new Error('add du lieu ca si bi fail')
  }
  return null // Do BE k return
}
