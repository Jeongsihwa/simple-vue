import axios from "axios";

const DOMAIN = () => `http://localhost:8080`;

// GET
const USER_LIST_URL = () => `${DOMAIN()}/findAll`;
export const getUserListRequest = async () => {
  const result = await axios
    .get(USER_LIST_URL())
    .then((response) => {
      const responseBody = response.data;
      return responseBody;
    })
    .catch((error) => {
      if (!error) return null;
      const responseBody = error.response.data;
      return responseBody;
    });
  return result;
};
